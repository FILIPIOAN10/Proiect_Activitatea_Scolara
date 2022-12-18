# Proiect_Activitatea_Scolara
Creati o aplicatie care sa permita managementul unei institutii de invatamant.
Aplicatia trebuie sa contina urmatoarele puncte cheie ca si functionalitate:
- Aplicatia va avea mai multe tipuri de useri: Admin, Elev, Profesor, Parinte,
Contabil
- Indiferent de tipul de user creat, o sa avem urmatoarele informatii
obligatorii: Numele full, Nume de utilizator (generat automat folosind doar litere
si cifre din minim 6 si maxim 10 caractere, unic in aplicatie), email (obligatoriu
doar email de tipul gmail).
- Vom avea entitatea Scoala care va avea ca si membri toti useri pe care ii
vom vrea, indiferent de tipul userului, o lista de sali de clasa cu numarul aferent
(ex: Sala1 cu descrierea Laborator Chimie, Sala2 cu descrierea Laborator Fizica,
Sala3 cu descrierea Sala Sport etc.), o lista de discipine care se predau in
scoala respectiva (ex: Romana, Biologie, Matematica, Germana, Japponeza,
etc.)
- Userul Admin este tipul de user care are cele mai importante drepturi in
aplicatia noastra, e singurul tip de user care poate genera o parola pentru orice
alt tip de user. Atunci cand instantiem un user de tipul admin trebuie sa ne
asiguram ca ii generam si lui o parola default initiala, formata din litere mici,
litere mari, cifre, macar un caracter special, lungime minima de 6 caractere si
lungime maxima de 12 caractere. Parola generata de Admin pentru alte tipuri de
useri va avea aceleasi reguli ca si cea a adminului.
- Parolele generate vor trebui sa fie scrise pentru fiecare tip de user intrun
fisier de tip .txt, numele fisierului va fi numele de utilizator generat la crearea
tipurilor de useri. Putem crea un folder in proiect pentru a tine fisierele cu
parola fiecarui user.
- Userul Admin o sa poata reseta parole, asta inseamna ca o sa primeasca
numele de utilizator pentru care trebuie sa reseteze parola si o sa inlocuiasca
vechea parola in fisierul userului corespunzator.
- Userul Admin ca putea sterge pe baza numelui de utizator orice membru
din lista de membrii din cadrul scolii, asta inseamna ca va sterge si fisierul
generat cu parola contului aferent, daca exista
- Userul Admin va avea posibilitatea sa genereze un fisier cu numele
“ListaMembriiScoala”, care are o lista a tuturor membrilor din scoala, in
formatul:
Nr 1, Maria Popescu, Elev; Nr 2, Emil Ionescu, Profesor; Nr 3, Ion
Ionescu, Contabil; etc.
- Userul Elev va avea urmatoarele informatii aditionale: gen, varsta, data
nasterii in formatul (AN-LUNA-ZI), adresa completa, lista de materii la care
participa, clasa din care face parte (ex: clasa 0, clasa 1, clasa 2, etc) cu
mentiunea ca scoala poate avea elevi pana in clasa a 12-a, daca are bursa
scolara sau nu
- O mentiune ar fi: clasele primare sunt clasa 0 -> clasa 4 si clasele
gimnaziale sunt clasa 5 -> clasa 8, clasele liceu sunt clasa 9 -> clasa 12
- Vom avea o entitate numita Materie care va avea urmatoarele informatii:
numele materiei (poate fi doar din lista disciplinelor aferente scolii), lista de
note, numarul salii unde se preda materia din cele existente in cadrul scolii, lista
de teme incarcate (care reprezinta o lista de fisiere incarcare de catre elev,
fiecare fisier incarcat va fi cu urmatorul format de nume: Nume utilizator elev +
Nume materie + data curenta in milisecunde). Fiecare Elev la creere va avea
creat automat si un folder cu numele “Numele complet elev + Teme”, unde se
vor salva toate temele create.
- Folosind userul de tip Elev ii vom putea asigna o lista de materii la care
participa, pentru a face orice actiune avem nevoie de parola generata de catre
Admin, in cazul in care dorim sa facem o actiune si parola nu e generata o sa
aruncam o exceptie care ne spune ca nu suntem autorizati sa facem aceasta
actiune si trebuie sa contactam adminul scolii pentru o generare de parola
- Tot pe baza verificarii parolei un elev isi poate incarca temele aferente
fiecarei materii la care participa, poate genera lista de note pe baza numelui
materiei dar nu are posibilitatea de a-si adauga note, poate genera o lista cu
media fiecarei materii (media fiecarei materii se calculeaza adunand toate
notele si impartind la numarul lor) la care participa, poate genera media anuala
(adunand mediile fiecarei materii si impartind la numarul de materii la care
participa)
- Fiecare Profesor va avea urmatoarele informatii aditionale: numele
disciplinei pe care o preda (din cele diponibile in cadrul scolii), tipul profesorului
(de scoala primara, gimnaziala sau liceu; poate avea doar o singura optiune),
numarul total de ore pe care le preda la scoala respectiva, salariul, data primei
angajari, lista claselor la care poate preda (ex: preda doar la clasa 5-a si la
clasa a 7-a), numar de telefon
- Fiecare profesor pe baza verificarii parolei valide poate face urmatoarele
actiuni: adauga note pentru elevii din clasele la care poate preda si doar pentru
materia pe care o poate preda, in cazul in care incearca sa adauge o lista de
note pentru un Elev dintr-o clasa la care nu preda sau pentru o materia la care
nu e calificat sa o predea trebuie sa aruncam o exceptie sa spunem ca nu e
autorizat sa faca acest lucru, profesorul mai poate genera un fisier cu numele
tuturor elevilor de la o clasa la care preda, fiecare profesor are posibilitatea sa
deschida si sa citeasca fisierele de teme incarcate de catre elevii din clasele la
care preda, la deschiderea fisierelor poate alege sa adauge o nota sau un
comentariu intr-un fisier cu o tema specifica (prin adaugarea unui comentariu
de genul “Revizuit” sau “Nota 10”, demonstram ca profesorul a facut inpectia
temei respective)

- Fiecare Parinte va avea urmatoarele informatii aditionale: numar de
telefon, adresa completa, varsta, data nasterii in formatul (AN-LUNA-ZI), lista
de elevi pentru care e parinte (in cazul in care are un singur copil va fi o lista cu
un singur elev), ocupatia
- Fiecare parinte pe baza verificarii parolei valide fiecare parinte va putea
vedea mediile pentru toti copii asignati, parintii vor avea posibilitatea sa
genereze un fisier cu toti profesorii care predau la clasele copiilor lor, in cazul in
care au doi copii si au acelasi profesor la Romana, acel profesor va aparea o
singura data in lista, fisierul va contine urmatorul format:
       Ion Popescu, Profesor Romana, 0733212342; Maria Ionescu,
Profesor Matematica, 0783333999;etc.
- Fiecare Contabil a avea urmatoarele informatii aditionale: daca este sau
nu expert contabil, numarul de telefon, adresa aditionala de email, daca poate
sau nu fi asignat la mai multe institutiii de invatamant (practic daca poate fi sau
nu contabil la mai multe scoli).
- Fiecare contabil pe baza verificarii parolei valide poate face urmatoarele
actiuni: va genera un raport care sa calculeze suma totala pe care scoala o are
de platit pentru salariile profesorilor, in formatul:
Ianuarie
Profesor de Romana - Ioan Popescu - 3000 Ron
Profesor de Matematica - Maria Ion - 5000 Ron
Total ianuarie - 8000 Ron
Februarie
….
Martie
….
etc
Total anual - 123000 Ron

- Contabilul tot pe baza parolei valide va mai putea genera un raport care
sa contina toti elevi din scoala care au bursa scolara, pentru elevii din clasele
primare bursa scolara este in valoare de 300 Ron, pentru elevii din clasele
gimnaziale este in valoare de 500 Ron, pentru elevii din liceu este in valoare de
800 Ron, raportul trebuie sa contina elevii impartiti in categorii si sa se
calculeze suma totala pe fiecare categorie, dupa cum urmeaza in exemplul
urmator:


Elevi clase primare:
Ion Ionescu
Maria Ion
Emil Nedescu
Total burse - 3 x 300 = 900 Ron
Elevi clase gimnaziale:
Maria Nicu
Nicole Marin
Total burse - 2 x 500 = 1000 Ron
Elevi clase liceu
Nicoleta Popescu
Total burse - 1 x 800 = 800 Ron
Total burse per scoala - 2700 Ron
- Adaugati la alegere oricare alte doua functionalitati proiectului, va fi
semnatura echipei voastre asupra proiectului.
Structura, e doar o structura orientativa de a porni si se adauga dupa nevoie si
alte clase, metode, fielduri, getters sau setters:
- o clasa abstracta User cu numeCompletUser, numeUtilizator, email
- urmatoarele clase ca Admin, Elev, Profesor, Parinte, Contabil vor extinde
clasa User, fiecare clasa va avea caracteristicile enumerate si actiunile aferente
- o clasa Scoala care va avea List<User> ca si membrii ai scolii, o lista de
sali (putem face un Enum care sa contina toate salile posibile, as sugera macar
12 sali de clasa sa aveti, avand in vedere ca scoala are 12 clase), o lista de
discipline (aici putem face tot un Enum care sa contina toate materiile posibile,
adaugati minim 7-8 materii posibile)
- as sugera si o clasa numita Util care sa contina functii comune care vor fi
folosite de mai multe ori de-a lungul proiectului, un exemplu ar fi sa validam ca
numarul de telefon e valid deoarece mai multe tipuri de user au numar de
telefon, sa ne asiguram ca generam o parola valida, sa ne asiguram ca un user
are o parola deja generata, orice actiune care se repeta de mai multe ori pentru
mai multi useri poate fi considerata o actiune comuna si utila in ansamblul
proiectului
- o clasa Main in care sa va creati toate obiectele si sa testati
functionalitatea
