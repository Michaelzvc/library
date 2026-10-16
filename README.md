# Planeringsmall — Projektskiss

Fyll i denna mall innan ni börjar koda. Skissen är ett första utkast, inte ett facit — det är både normalt och förväntat att klassnamn och struktur ändras när ni väl börjar implementera. Spara den ifyllda mallen som README i er första commit, tillsammans med namn på den/de som jobbar i projektet.

## Projektidé
projektet
Biblioteksystem där man kan låna, lämna tillbaka, lägga till och ta bort media. 

## Superklass

- Namn: MediaItem
- Gemensamma fält: ID, Title, Year, Genre
- Gemensamma metoder: displayInfo, getMediaType

## Subklasser (minst tre)

1. Book — Visar författare och mängden sidor i boken, displayInfo overridas.
2. Movie — Visar direktör och längden i minuter, displayInfo overridas.
3. Music — visar artist och längden i sekunder, displayInfo overridas.

## Interface

- Namn: Loanable
- Metod(er):borrow()
- Implementeras av (minst två subklasser): Book, Movie

## Meny
1. Display all media
2. Add media
3. Search for Title
4. Remove media by ID
5. filter by genre
6. Display statistics
7. Borrow/return media
8. Exit


## Felscenarion
Om man skriver ett negativt nummer på ID eller år
Man kan inte använda decimaler utan måste ange hela nummer. 


## Motivering (fylls i senare i veckan)

Hade först att man kunde låna allt även musik, men ändrade mig senare för tänkte att man inte skulle kunna låna utan bara köpa musik.
Hann inte implementera det då jag missbedömde vilken vecka uppgiften skulle vara färdig. 
PS. My bad G