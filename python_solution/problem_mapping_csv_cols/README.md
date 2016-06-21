<b>Problem statement:</b><br>
<br>
Given 2 CSV files<br>
  And the first CSV file has all the content<br>
  And the second one only contains a list of columns <br>
 When I call my program<br>
 Then it should perform a lowercase for all the columns in file 1<br>
  And it should only print values from file 1 if the column appears in second file<br>
  And for column that does not appear in the second file then it should appear as '' value.<br>
  
<br>
<b>Problem URL: </b><br>
http://stackoverflow.com/questions/37914320/copying-the-matching-columns-from-csv-file/37914962#37914962
<br>
<b>Comment:</b><br>
Cherrypicking CSV content from 2 CSV files.

<br>

<b>Caller's example code:</b><br>
```python
import csv

file1 = csv.DictReader(open("file1.csv"))   #reading file1.csv
file1_Dict = {} # the dictionary of lists that will store the keys and values as list 
for row in file1: 
    for column, value in row.iteritems():
        file1_Dict.setdefault(column,[]).append(value)

for key in file1_Dict: # converting the keys of the dictionary to lowercase
    file1_Dict[key.lower()] = file1_Dict.pop(key)

file2 = open("file2.csv")    #reading file2.csv
file2_Dict ={}               # store the keys into a dictionary with empty values
for row2 in file2:
    row2 = row2.split(",")
    for i in row2:
        file2_Dict[i] = ""

```