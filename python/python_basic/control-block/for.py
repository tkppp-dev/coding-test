# list
list = [1,23,4,5]
for el in list:
  print(str(el) + " ", end="")

print()

# tuple
tupleInList = [(1,2), (2,4)]
for (first, second) in tupleInList:
  print('first: ' + str(first) + ' second: ' + str(second))
  
# dict
dict = {'1': '123', '2': '124'}
for key in dict.keys():
  print(key + " " + dict[key])
  
for (key, value) in dict.items():
  print(key + " " + value)
  

# 범위 순회 : range(end) == 0 until end, range(start, end) == start until end
# range(start, end, step) == start until end step n

for i in range(10, 1, -1):
  print(str(i) + " ", end="")
print()

# index, value 순회 : enumerate(list)

for index, el in enumerate(list):
  print(index, el)