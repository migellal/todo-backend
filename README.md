# Projekt

Projekt zawiera backend do aplikacji todo do której [frontend zjnajduje się tutaj](https://github.com/migellal/todo-frontend)

## Szczegóły techniczne

Aby uniknąć problemów z CORSEM dodałem adnotację @CrossOrigin która wskazuje na frontend uruchomiony na porcie 4200. Zamiast korzystać z generatora UUID użyłem wzorca singleton i klasy statycznej, co powoduje generowanie kolejnych numerów id dla poszczególnych zadań, ale wpływa również na testowanie aplikacji, stąd oznaczenie "order" w testach. 

## Usprawnienia
W ramach usprawnień można by poprawić walidację po stronie backendu (w tym momencie cała znajduje się po stronie frontendu). Lepsza obsługa błędów http to również ważny punkt.
Do tego mozna by rozbić serwis "TodoService" jeśli pojawiły by się kolejne odpowiedzialności (np. bardziej złożone mapowanie). Można by też rozbić pakiet "model" na osobne pakiety dla DTO oraz DAO. Oczywiście dodanie dokumentacji również byłoby wskazane.

# Zadanie

## Wymagania

### User Story:
Jako użytkownik, chcę mieć prostą aplikację do zarządzania zadaniami, która umożliwia dodawanie, usuwanie i przeglądanie zadań przez interfejs REST API.
### Polecenie:
Stwórz prostą aplikację do zarządzania zadaniami (to-do list) w Spring Boot, która posiada funkcje dodawania, usuwania i przeglądania zadań.
### Wymagania:
```
Backend:
POST /tasks: Dodanie nowego zadania. Zadanie ma zawierać tytuł (minimum 3 znaki).
GET /tasks: Pobieranie wszystkich zadań.
DELETE /tasks/{id}: Usuwanie zadania po ID.
```
### Struktura zadania:
```
Każde zadanie powinno zawierać:
Unikalne ID (np. generowane przy pomocy UUID).
Tytuł (title) – tekst.
Opis (description) – opcjonalny.
```
### Testy:
```
Testy jednostkowe dla logiki dodawania i usuwania zadań (np. za pomocą JUnit)
```
### Frontend
```
Utwórz prosty interfejs użytkownika (technologia dowolna):
Pole tekstowe i przycisk „Dodaj”, które pozwolą użytkownikowi dodać nowe zadanie.
Lista wyświetlająca wszystkie zadania z przyciskiem „Usuń” obok każdego zadania.
```