CREATE TABLE WNIOSKI
(
wniosek_id int NOT NULL PRIMARY KEY,
stan varchar(50),
nr_rej_wniosku int,
--część 1
jednostka_org_uczelni varchar(100),
wnioskodawca varchar(50),
wnioskodawca_tel int,
os_dok_opisu_prz_zam varchar(100),
os_dok_opisu_prz_zam_tel int,
os_dok_opisu_prz_zam_e_mail varchar(40),
--część 2
przedmiot_zamowienia varchar(1000),
przedmiot_zamowienia_okres date,
--część 3
metoryczne_uzas_cel_dok_zakupu varchar(900),
termin_realizacji_zam date,
--część 4
szacunkowa_wartosc_zam double,
ustalenia_szac_wartosci varchar(100),
osoba_dok_ustalenia_szac_wart_zam varchar(50),
kwota_przeznaczona_sfinans_zam double,
zrodlo_sfinansowania varchar(100),
data_osoby_szacujacej date,
osoba_szacujacaID int REFERENCES users(user_id), --FOREIGN KEY....
data_wnioskodawcy date,
osoba_wnioskodawcaID int REFERENCES users(user_id), --FOREIGN KEY
--część 5
potwierdzenie_pokrycia_fin_ze_srodkow varchar(200),
potwierdzenie_pokrycia_fin_ze_srodkow_data date,
kierownik_dzialu_naukID int,
potwierdzenie_zgodnosci_budzet varchar(200),
potwierdzenie_zgodnosci_budzet_data date,
kierownik_BRPM_BWM_ID int, --foreign key
--część 6
zgodnosc_z_planem_rzeczowym varchar(200),
kontrasygnata_uwagi varchar(500),
kontrasygnata_data date,
kwestor_ID int  REFERENCES users(user_id), --foreign key

szef_pionuID int REFERENCES users(user_id), --foreign key

--WYPEŁNIA DZIAŁ ZAMÓWIEŃ PUBLICZNYCH
data_zlozenia_w_dziale_zam_pub date,
osoba_przyjmujaca_wniosek_ID int REFERENCES users(user_id), --foreign key
uwagi_działu_zam_pub_dot_wniosku varchar(1000),

komisja_przetargowa varchar(100),
dzial_aparatury_badawczej varchar(100),
wnioskodawca_z_uzg_z_dz_nauki varchar(100),
dzial varchar(50),
dzial_value varchar(100),
pusty varchar(50),
pusty_value varchar(100),
wnioskodawca_tabelka varchar(100),
kierownik_dzialu_zam_pub_ID int REFERENCES users(user_id), --foreign key
pelnomocnik_rektora_ID int REFERENCES users(user_id) --foreign key
);



CREATE TABLE PRZEDMIOT_ZAMOWIENIA
(
przedmiot_zamowienia_id int NOT NULL PRIMARY KEY,
wniosek_ID int REFERENCES WNIOSKI(wniosek_id),
data_osoby_dokonujacej_opisu date,
osoba_dokonujaca_opisu_ID int REFERENCES users(user_id), --foreign key
osoba_opiniujaca_tryb_udzielania_zam_ID int REFERENCES users(user_id), --foreign key
pelnomocnik_rektora_ID int REFERENCES users(user_id) --foreign key
);



CREATE TABLE PRZEDMIOT_ZAMOWIENIA_ITEM
(
przedmiot_zam_item_id int NOT NULL PRIMARY KEY,
nazwa_opis_przedmiotu_zam varchar(50),
jednostka_miary varchar(20),
ilosc int,
kwota_przeznaczona_na_real double,
pozycja_w_planie_zam_jedn int,
opinia_dot_trybu_udzielania_zam varchar(200),
przedmiot_zamowienia_ID int REFERENCES PRZEDMIOT_ZAMOWIENIA(przedmiot_zamowienia_id)
);

CREATE TABLE users (
user_id int NOT NULL PRIMARY KEY,
imie VARCHAR(20),
nazwisko VARCHAR(20),
login VARCHAR(20) NOT NULL UNIQUE,
haslo VARCHAR(32) NOT NULL,
rola VARCHAR(50) NOT NULL,
email VARCHAR(60) NOT NULL
);

CREATE TABLE uwagi (
uwaga_id int NOT NULL PRIMARY KEY,
tresc VARCHAR(2000),
wniosek_id int REFERENCES WNIOSKI(wniosek_id) ON DELETE CASCADE,
user_id int REFERENCES USERS(user_id)
);