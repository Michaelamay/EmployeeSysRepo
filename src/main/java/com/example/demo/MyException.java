package com.example.demo;

class MyException extends RuntimeException {

  MyException() {
    super("Something bad occured.");
  }
}