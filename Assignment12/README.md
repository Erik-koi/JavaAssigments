# Calculator assignment

## Program idea

This small Java program demonstrates a calculator model from the MVC pattern. The
`Calculator` object stores its current total, adds non-negative integers, returns the
total, and can reset it to zero. `Main` is a temporary demonstration program.

## Calculator source code

```java
public class Calculator {
    private int value;

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only non-negative integers can be added.");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }
}
```

## How the class works

The private field `value` stores the calculator's current total. It starts at Java's
default value, zero. The `reset()` method sets it back to zero. The `add(int number)`
method checks its input before changing the total: a negative number causes an
`IllegalArgumentException`, while a non-negative number is added. The `getValue()`
method returns the current total without changing it.

`Main` creates a calculator, adds `12`, `7`, and `5`, and prints the result (`24`).
It then resets the calculator and demonstrates the error raised by trying to add `-3`.

## Using GitHub Copilot

I used GitHub Copilot as a coding assistant to turn the assignment requirements into
a small Java implementation. I reviewed the generated code, checked that the negative
input is rejected before the total changes, and compiled and ran the example. The
`add` method is deliberately short so its behavior is easy to inspect.

There are several useful ways to ask Copilot for this method: provide just the method
signature and accept or edit its completion; provide the signature and the input
check, then ask for the remaining body; or write an English comment describing the
validation and addition. A loop is unnecessary for adding one integer. If the
requirement changed to adding a collection, a `for` or `while` loop could be
appropriate, and the proposed code should still be reviewed and tested.

## Reflection: applicability to my coding style

For this small, clearly specified task, Copilot is useful for quickly drafting routine
code and showing alternative implementations. I prefer short methods and explicit
validation, so I would use its suggestions as a starting point and keep the final
version that is simplest to read. I would not accept a completion without checking
edge cases and running the program.

**Benefits:** faster initial implementation, less repetitive typing, quick examples
of Java syntax, and help drafting explanations or tests.

**Drawbacks:** generated code can misunderstand a requirement, omit edge cases, or
look correct while containing a bug. It may also add unnecessary complexity. The
developer remains responsible for reviewing, testing, and understanding the code.
