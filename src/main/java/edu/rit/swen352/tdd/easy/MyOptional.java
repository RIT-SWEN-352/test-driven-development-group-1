package edu.rit.swen352.tdd.easy;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * MyOptional contains a single value, of any type, or nothing at all.
 *
 * <p>
 * This must be an immutable
 * <a href='https://en.wikipedia.org/wiki/Value_object'>Value Object</a>.
 * </p>
 *
 * <p>
 *   For example:
 *   <ul>
 *     <li><code>MyOptional.of(42)</code> is a non-empty optional containing an integer: 42.</li>
 *     <li><code>MyOptional.empty()</code> is an empty optional.</li>
 *     <li><code>MyOptional.of("My string")</code> is a non-empty optional containing a string: "My string".</li>
 *   </ul>
 * </p>
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>factories:
 *     <ul>
 *       <li>{@code empty()} -- return an empty optional</li>
 *       <li>{@code of(value:T)} -- return a non-empty optional</li>
 *       <li>{@code ofNullable(value:T)} -- return an optional that might be empty</li>
 *       <li>NFR: hide any constructors; forces clients to use a factory function</li>
 *     </ul>
 *   </li>
 *   <li>{@code isPresent():boolean}: queries if the optional is not empty</li>
 *   <li>{@code get():T}: returns the value; throws {@link java.util.NoSuchElementException} if empty</li>
 *   <li>{@code ifPresent(Consumer)}: executes a {@link java.util.function.Consumer} if a value is present</li>
 * </ul>
 *
 * @param <T> the type of value.
 */
public class MyOptional<T> {

    T value;
    static final String nullParamMsg = "Value cannot be null";
    static final String noSuchElem = " illegal get method on empty optional";

    private MyOptional(){
        value = null;
    }

    private MyOptional(T value){   
        this.value=value; 
    }

    public static <T> MyOptional<T> empty(){
        return new MyOptional<T>();
    }

    public static <T> MyOptional<T> of(T val){
        if(val==null){
            throw new InvalidParameterException(nullParamMsg);
        }
        return new MyOptional<T>(val);
    }

    public static <T> MyOptional<T> ofNullable(){
        return MyOptional.empty();
    }

    public static <T> MyOptional<T> ofNullable(T val){
        if(val==null){
            return MyOptional.empty();
        }else{
            return MyOptional.of(val);
        }
    }

    boolean isPresent(){
        return value!=null;
    }

    T get() throws NoSuchElementException{
        if(isPresent()){
            return value;
        }else{
            throw new NoSuchElementException(noSuchElem);
        }
    }

    void ifPresent(Consumer<T> cons){
        cons.accept(value);
    }

}
