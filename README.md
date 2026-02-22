# 💳 Mobile Credit Card Simulator (Academic Project)

![Platform](https://img.shields.io/badge/Platform-Android-green)
![Language](https://img.shields.io/badge/Language-Kotlin-purple)
![IDE](https://img.shields.io/badge/IDE-Android%20Studio-blue)
![Min SDK](https://img.shields.io/badge/Min%20SDK-Android%205.0%2B-orange)
![Status](https://img.shields.io/badge/Status-Academic%20Project-yellow)

---

## 📌 About The Project

This project is a **Credit Card UI Simulator** developed as an academic assignment for the discipline:

> **Programming for Mobile Devices (6th semester)**  
> Bachelor's Degree in **Analysis and Systems Development (ADS)**

The application simulates a credit card interface where the user can:

- Enter cardholder name
- Enter card number (with automatic spacing mask)
- Enter expiration date (MM/YY format with automatic formatting)
- Enter CVV
- Flip the card (front/back view)
- Automatically detect and update the card brand (Visa, Mastercard, Elo)
- Enable/disable editing mode
- Validate input before saving

The UI dynamically updates the card preview in real time as the user types.

---

## ⚠️ Important Notice (Academic Use Only)

This project is strictly for **academic and educational purposes only**.

It is **NOT intended for commercial use**.

The interface uses the **Banco do Brasil logo and visual references** exclusively for study and learning purposes.  
All trademarks, logos, and brand assets belong to their respective owners.

This repository must not be used for commercial distribution, monetization, or brand representation.

---

## 🚀 Features

- 🔄 Card flip animation using `ViewFlipper`
- ✍️ Real-time TextView updates from EditText
- 💳 Automatic card number mask (#### #### #### ####)
- 📅 Automatic expiration date formatting (MM/YY)
- 🏷️ Card brand detection based on number prefix
- 🔐 Basic form validation before saving
- 🎨 Custom CardView styling

---

## 🧠 Card Brand Detection Logic

The application identifies the card brand based on the first digits:

- **Visa** → Starts with `4`
- **Mastercard** → Starts with `5` or `2`
- **Elo** → Default fallback

The brand icon updates dynamically on both front and back of the card.

---

## 🛠️ Technologies Used

- **Kotlin**
- **Android SDK**
- **Android Studio**
- **ConstraintLayout**
- **CardView**
- **ViewFlipper**
- **addTextChangedListener**
- **AlertDialog**

---

## 🎓 Academic Context

This project was developed as part of the discipline:

> **Programming for Mobile Devices – 6th Semester**

Main learning objectives:

- Android UI design
- Layout structuring
- Event handling
- Input masking implementation
- State control (Edit / Save logic)
- Basic validation strategies

---

## 📂 Project Structure

app/
├── java/com/atividadeum/cartaomobile/
│   └── MainActivity.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── card_front.xml
│   │   └── card_back.xml
│   ├── drawable/
│   ├── anim/
│   └── values/

---

## 📄 License

This repository is intended strictly for **academic study and portfolio demonstration**.

Commercial use is prohibited due to the inclusion of third-party brand assets.
