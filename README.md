# gdl-to-ispl
Translate Game Description Language (GDL) to ISPL, the specification language of the model checker MCMAS.

# How to run
1. Download the pre-compiled jar file \texttt{gdl2ispl.jar} of the GDL to ISPL translator is included in the software archive. 
2. Execute the command below:
```
$ java -jar gdl2ispl.jar <path_to_gdl_file> <output_path>
```
where <path\_to\_gdl\_file> is the absolute path of the GDL description file and <output\_path> is the absolute path of the output file. 

Example usage:
```
$ java -jar gdl2ispl.jar
        C:\Users\Ian\Desktop\connect4.kif
        C:\Users\Ian\Desktop\connect4.ispl
```

Please ensure the input GDL description is syntactically correct and stratifiable. Otherwise, the translator may abort erroneously or loop indefinitely.


