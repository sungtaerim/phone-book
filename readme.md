"Записная книжка"

Данные хранятся в TreeMap<String, String>, ключом является Имя абонента. Это позволяет хранить несколько номеров телефонов для одного абонента. 

Добавление записи:
  - ввод номера телефона, затем ввод имени контакта;
  - ввод имени контакта, затем добавление номера телефона;
  - команда LIST для просмотра всех записей.

При вводе номера, который был уже введён ранее, новый контакт не создаётся. 
При вводе имени, которые уже есть в списке, выводятся все номера телефонов, записанные для этого имени.
Номер телефона и имя проверябтся с помощью регулярных выражений. 
