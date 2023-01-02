This project focuses on Dagger implementation in a multi-module project.
For this, i have created a poc flight booking app. First an overview.
Flight booking app-
app (Application module)
login (feature module)
register (feature module)
bookings (feature module)
domain (use cases module (non-android))
data (repository module)


When looking at dependencies using Dagger, it is important to consider the scope for 
each instance. For example, a single DB instance is required for entire app lifetime. 
So it can be provided via ApplicationComponent in app module. Then individual project 
module can have their own sub-components (LoginComponent, RegisterComponent etc.). 

Each subcomponent extends ApplicationComponent so it can use the DB instance provided 
by ApplicationComponent. This is the benefit of subcomponents, they allow to define scope 
for different instances provided by Dagger. 

There are many ways to provide instances via Dagger. Another approach was to include modules 
directly wherever needed. For eg. A AddUserModule will directly include the RepositoryModule 
in its Module declaration as follow -
@Module(includes = [RepositoryModule::class])

This would supply the required BookingRepository instance, which AddUserModule can use to 
provide its own instances. However, in this case no scoping is involved. So it will probably 
lead to multiple instances of Repository class being created each time it is requested from 
the Dagger graph. That is why although this is approach works and is pretty simple to 
implement. But it is not the most efficient. 

Another approach is component dependencies. Component dependencies are similar to Subcomponents, 
in fact they were introduced before Subcomponents as a way to share dependencies across components. 
There are some pros and cons when comparing the two. More details later in this file.


Subcomponents:
Subcomponents are extensions of the parent component. It can be used for:

Partition the dependencies into different compartments.
Avoid the parent component to have too many dependencies bound to it.
Subcomponent and its parent component have different scope (lifespan).
The subcomponent scope is smaller than its parent.

Subcomponent can access all its parent bound dependencies, but not vice versa.

Two subcomponents, each will be able to access parent bound dependencies,  
but they cannot access dependencies between them...


Component dependencies: 
Component dependencies are another way to share dependencies between components. 
They are declared as @Components(dependencies = [DependentComponentName::class])
Then the depending Component should also define a Factory/Builder whose method includes 
the dependent component as an argument. 
The dependent component should explicitly mention the dependencies which it exposes to 
the depending component. See code for more details.


Subcomponent builder vs factory interfaces
Subcomponent can be created via Builder or Factory interfaces using the following annotation 
for individual interface -
@Subcomponent.Builder or @Subcomponent.Factory.

Both are basically 2 ways to create instance of a Subcomponent. 
Builder interface was introduced earlier in Dagger compared to Factory. 
Builder requires a separate function to supply each external dependency to the component graph
The function will return instance of Builder. And finally it will have a build function 
that returns instance of the Subcomponent itself. 

Factory interface has a single function create() that returns instance of the subcomponent. 
External dependencies required by the component are supplied as arguments to the create function. 

For external instances, one has to use @BindsInstance annotation to bind the instance to 
the component's dependency graph. 
Modules whose constructor do not have any arguments can be omitted from the Builder/Factory. 

Same can also apply for components i guess.

My thoughts on using module with constructor arguments vs 
subcomponents. 
With first approach we dont need subcomponents .i.e. modules 
can simply include other modules that they depend on 
(or which they are composed of). But then we lose the 
custom scope for these instances .i.e. each time the 
provides method is called, it will pass a new instance of 
the requested class. 

component dependency vs subcomponents - 
component dependency requires the dependent component to explicitly mention which 
dependencies it wishes to expose to the depending components, so it is bit easier to 
read. 

subcomponents by default are able to access bound dependencies of the parent component. 

NOTE: Modules cannot be scoped..
