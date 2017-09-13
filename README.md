# Hazard Bot

## Workstation setup

```bash
brew install mysql
brew services start mysql
```

## Set up MySQL

```
$ mysql -uroot
mysql> create database hazardbot;
mysql> create user 'hazardbot_user'@'localhost' identified by 'password';
mysql> grant all on hazardbot.* to 'hazardbot_user'@'localhost';
```