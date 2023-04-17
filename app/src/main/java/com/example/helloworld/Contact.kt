package com.example.helloworld

// Salah satu fungsi kita Implement Serializable adalah
// memungkinkan data bertipe object Contact dikirim melalui Intent.putExtra
class Contact: java.io.Serializable {
    var name = "nama"
    var number = "number"
    var gender = "unknown"
    var email = "email@email.com"
    var address = "alamat saya"
    var notes = ""

    constructor(
        name: String,
        number: String,
        gender: String,
        email: String,
        address: String,
        notes: String
    ) {
        this.name = name
        this.number = number
        this.gender = gender
        this.email = email
        this.address = address
        this.notes = notes
    }
}