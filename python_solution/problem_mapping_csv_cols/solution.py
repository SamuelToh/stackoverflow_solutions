import csv

csv_data1_filepath = './file1.csv'
csv_data2_filepath = './file2.csv'

def main():

        # import nem config and data into memory
        data1 = list(csv.reader(file(csv_data1_filepath, 'r')))
        data2 = list(csv.reader(file(csv_data2_filepath, 'r')))

        file1_header = data1[0][:] # Get f1 header
        file2_header = data2[0][:] # Get f1 header
        lowered_file1_header = [item.lower() for item in file1_header] # lowercase it
        lowered_file2_header = [item.lower() for item in file2_header] # do it for header 2 anyway

        col_index_dict = {}
        for column in lowered_file1_header:
            if column in file2_header:
                col_index_dict[column] = lowered_file1_header.index(column)
            else:
                col_index_dict[column] = -1 # mark as column that will not be worked on later

        for column in lowered_file2_header:
            if not column in lowered_file1_header:
                col_index_dict[column] = -1 # mark as column that will not be worked on later

        # build header
        output = [col_index_dict.keys()]
        is_header = True

        for row in data1:
            if is_header is False:
                rowData = []
                for column in col_index_dict:
                    column_index = col_index_dict[column]
                    if column_index != -1:
                        rowData.append(row[column_index])
                    else:
                        rowData.append('')
                output.append(rowData)
            else:
                is_header = False

        print(output)


if __name__ == '__main__':
        main()