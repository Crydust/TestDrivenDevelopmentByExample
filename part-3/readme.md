# Part 3 - Chapter 30  - Design patterns

## Command

Store a method call and all required parameters in an object.
In java that would often be a class implementing one of:
* `java.lang.Runnable`
* `java.lang.Callable`
* `javax.swing.Action`
Since Java 8 you can use a lambda to succinctly create one of these.


## Value object

Immutable object wrapping a value.
This avoids the aliasing problem where you fear someone altering your fields, which would invalidate cached calculations.


## Null object

An object representing the empty state.
Use an object with noop behavior instead of having null checks and conditions everywhere.


## Template method

A method that only calls other methods.
Subclasses can rely on the methods being called in the same sequence.
Variations in behavior are possible by extending the class.
It is easier to first write the long method inline and extract variable code from there.
Methods can be abstract when a default behavior makes no sense.


## Pluggable object

Similar to the strategy pattern, as it lets you swap the behavior of an object at runtime.
The difference lies in the intent as a pluggable object is meant to be replaced by a mock in a test.


## Pluggable selector

Move the choice of which method to call into a switch when you have multiple tiny classes with only one method.


## Factory method

A more flexible way of creating objects compared to constructors.
Allows you to return a subclass when needed.


## Imposter

Create a new kind of object and pretend it is the same as an existing object.
Examples include:
* Null object
* Composite


## Composite

Object that behaves as a collection of objects.
Can be an imposter for a singular object.


## Collecting parameter

An object you can pass on to a method as a "sink".
Example of where this is done: `java.io.Externalizable#writeExternal(ObjectOutput out)`


## Singleton

Please don't.
