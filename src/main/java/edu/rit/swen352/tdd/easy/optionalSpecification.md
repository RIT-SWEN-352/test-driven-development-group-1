
MyOptional contains a single value, of any type, or nothing at all.

<p>
This must be an immutable
<a href='https://en.wikipedia.org/wiki/Value_object'>Value Object</a>.
</p>

<p>
For example:
<ul>
    <li><code>MyOptional.of(42)</code> is a non-empty optional containing an integer: 42.</li>
    <li><code>MyOptional.empty()</code> is an empty optional.</li>
    <li><code>MyOptional.of("My string")</code> is a non-empty optional containing a string: "My string".</li>
</ul>
</p>

<p>
You must implement these features:
<ul>
<li>factories:
    <ul>
    <li> empty() -- return an empty optional</li>
    <li> of(value:T) -- return a non-empty optional</li>
    <li> ofNullable(value:T) -- return an optional that might be empty</li>
    <li>NFR: hide any constructors; forces clients to use a factory function</li>
    </ul>
</li>
<li> isPresent():boolean: queries if the optional is not empty</li>
<li> get():T : returns the value; throws {@link java.util.NoSuchElementException} if empty</li>
<li> ifPresent(Consumer): executes a {@link java.util.function.Consumer} if a value is present</li>
</ul>

@param <T> the type of value.
