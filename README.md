Railway Reservation (Simple Java Console App)

A small console-based railway ticket booking simulation written in Java.

Supports booking berths (Lower / Middle / Upper), RAC, and a waiting list with simple rules for allocation and cancellation.

---

> Features

Book tickets with berth preference: lower, middle, upper.

If preferred berth unavailable, suggests other available berths or RAC.

Maintains separate lists for:

* Confirmed booked tickets

* RAC tickets

* Waiting list tickets

Cancel tickets and automatically promote RAC → confirmed and waiting → RAC.

Simple console menu for operations (book, cancel, print, show availability, exit).

---

> Requirements

Java 8 or above.

Terminal / Command Prompt.

---

> Usage

After running,

```

Welcome to ticket booking application
1.Book 
 2.Cancel 
 3.Print booked tickets 
 4.Print available tickets 
 5.exit

```

*Book flow (example)

Choose 1 to Book

Enter passenger name: Aravind

Age: 28

Gender: Male

Berth preference: lower

If preferred berth is unavailable, program will show other options (numbered). Choose one of them (1/2/3/4). For RAC prompt or waiting list, follow console instructions.

*Cancel flow (example)

Choose 2 to Cancel

Enter your name e.g. Aravind

The application finds the first booked passenger with that name (case-insensitive) and cancels the ticket.

If RAC list is non-empty, the first RAC passenger gets promoted to a confirmed berth (the canceled berth type).

If waiting list non-empty, the first waiting passenger moves to RAC.

*Print booked tickets

Choose 3 — shows Confirmed, RAC and Waiting lists with counts.

*Print available tickets

Choose 4 — shows available counts for berths, RAC and waiting list.

---
