# Pattern 1: Star Pyramid

rows = 5

print("Star Pyramid:\n")

for i in range(1, rows + 1):

    print(" " * (rows - i) + "* " * i)


# Pattern 2: Number Triangle

print("\nNumber Triangle:\n")

for i in range(1, rows + 1):

    for j in range(1, i + 1):

        print(j, end=" ")

    print()