def groupAndSortOwners(files):

    result = {}

    for file_name, owner in files.items():

        if owner not in result:
            result[owner] = []

        result[owner].append(file_name)

    for owner in result:
        result[owner].sort()

    return result


files = {
    'Input.txt': 'Albert',
    'Code.py': 'Stanley',
    'Output.txt': 'Albert',
    'btech.txt': 'Albert'
}

print(groupAndSortOwners(files))