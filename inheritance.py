# Base Class
class Animal:

    def __init__(self, name):

        self.name = name

    def speak(self):

        print("Animal makes a sound")


# Derived Class (Inheritance + Overriding)
class Dog(Animal):

    def speak(self):

        print(self.name, "says Woof!")


class Cat(Animal):

    def speak(self):

        print(self.name, "says Meow!")


# Method Overloading Simulation
class Calculator:

    def add(self, a, b=None, c=None):

        if b is not None and c is not None:

            return a + b + c

        elif b is not None:

            return a + b

        else:

            return a


# Main Program
if __name__ == "__main__":

    dog = Dog("Buddy")

    cat = Cat("Whiskers")

    dog.speak()

    cat.speak()

    calc = Calculator()

    print("Sum of 1 number:", calc.add(5))

    print("Sum of 2 numbers:", calc.add(5, 10))

    print("Sum of 3 numbers:", calc.add(5, 10, 15))