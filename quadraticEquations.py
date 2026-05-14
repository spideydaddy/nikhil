import math


class QuadraticEquationSolver:

    def findRoot(self, a, b, c):

        if a == 0:

            print("Not a quadratic equation.")

            return

        discriminant = b**2 - 4 * a * c

        if discriminant > 0:

            root1 = (-b + math.sqrt(discriminant)) / (2 * a)

            root2 = (-b - math.sqrt(discriminant)) / (2 * a)

            print("Roots are real and distinct:")

            print("Root 1 =", root1)

            print("Root 2 =", root2)

        elif discriminant == 0:

            root = -b / (2 * a)

            print("Roots are real and equal:")

            print("Root =", root)

        else:

            real_part = -b / (2 * a)

            imaginary_part = math.sqrt(-discriminant) / (2 * a)

            print("Roots are complex:")

            print("Root 1 =", real_part, "+", imaginary_part, "i")

            print("Root 2 =", real_part, "-", imaginary_part, "i")


solver = QuadraticEquationSolver()

solver.findRoot(1, -3, 2)