# mipt4note
 
# Activity elementų sąveika ir duomenų saugojimas
## Naudojant „Android Studio“ integruotą programavimo aplinką (IDE), sukurti užrašų (Notes) saugojimo programėlę.  Programėlė turi tenkinti šiuos reikalavimus:
### Bendroji dalis:
1)	Kintamųjų, metodų, klasių pavadinimai turi būti rašomi anglų kalba;
2)	Elementai turi turėti prasmingus pavadinimus (pvz. txtName vs EditText1);
3)	Kodas rašomas naudojant Java programavimo kalbos standartus e.g.
•	Kintamieji pradedami rašyti mažąja raide (pvz. txtUserName);
•	Konstantos rašomos didžiosiomis raidėmis atskiriant tarpais (pvz. OPT_CHARS);
•	Metodai rašomi pradedant mažąja raide (pvz. getWordsCount(String option));
4)	Visi metodai turi išvedinėti pranešimus apie jų iškvietimą į konsolės (console) langą (naudoti Log klasę);
### Specialioji dalis:
1)	Programėlėje turi būti trys Activity klasės: 
•	MainActivity – atvaizduoja vartotojo įvestus ir išsaugotus užrašus (šiam tiksliui galima naudoti ListView elementą arba ListActivity klasę). MainActivity  turi turėti meniu elementą su dviem pasirinkimai: Sukurti užrašą ir Ištrinti užrašą, kurie atitinkamai turi iškviesti AddNoteActivity arba DeleteNoteActivity.
•	AddNoteActivity – activity klasė skirta sukurti naują užrašą. Kiekvienas užrašas turi pavadinimą (name) ir turinį (content);
•	DeleteNoteActivity – activity klasė skirta ištrinti pasirinktą užrašą. Užrašai yra atvaizduojami Spinner elemente panaudojant vardą.
2)	Duomenų saugojimo būdas pasirenkamas laisvai (vidinė/išorinė atmintis/ preferences/ SqLite etc.);
3)	Programa turi tikrinti įvedamą tekstą;
