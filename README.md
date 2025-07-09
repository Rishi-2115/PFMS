# PFMS - Personal Finance Management System

A comprehensive Android application for managing personal finances, tracking expenses, investments, and financial planning.

## Features

### 📱 Core Functionality
- **Account Management**: Add, update, and manage multiple bank accounts
- **Transaction Tracking**: Record and categorize income and expenses
- **Expense Management**: Daily expense tracking with detailed categories
- **Budget Planning**: Set and monitor budgets for different categories
- **Financial Reports**: Generate comprehensive financial reports and graphs

### 💰 Investment Tracking
- **Mutual Funds**: Track both SIP and Lumpsum investments
- **Fixed Deposits**: Manage FD accounts and maturity tracking
- **Recurring Deposits**: RD management with interest calculations
- **Shares**: Stock portfolio tracking
- **NSC (National Savings Certificate)**: Investment tracking
- **KVP (Kisan Vikas Patra)**: Investment management

### 🛡️ Insurance Management
- **Life Insurance**: Policy tracking and premium management
- **Vehicle Insurance**: Vehicle and insurance policy management
- **Office Insurance**: Corporate insurance tracking
- **Electronic Insurance**: Electronics warranty and insurance

### 📊 Analytics & Visualization
- **Interactive Charts**: MPAndroidChart integration for data visualization
- **Pie Charts**: Expense distribution visualization
- **Graph Analytics**: Comprehensive financial trend analysis
- **Historical Data**: Transaction history with search functionality

## Technical Specifications

### 🔧 Development Details
- **Language**: Java
- **Platform**: Android
- **Target SDK**: 28 (Android 9.0)
- **Minimum SDK**: 18 (Android 4.3)
- **Version**: 1.0

### 📚 Dependencies
- **UI Components**: Android Support Library v28
- **Charts**: MPAndroidChart v3.0.1
- **Database**: SQLite (Custom DBHelper implementation)
- **Animation**: GIF Drawable support
- **UI Elements**: CardView, RecyclerView, ConstraintLayout

### 🏗️ Architecture
- **Database**: SQLite with custom helper classes
- **UI Pattern**: Activity-based navigation
- **Data Management**: Custom data providers for different modules
- **Storage**: Local SQLite database for offline functionality

## Installation

1. Clone the repository:
```bash
git clone https://github.com/Rishi-2115/PFMS.git
```

2. Open in Android Studio
3. Build and run on Android device or emulator

## Usage

1. **Initial Setup**: Create user account and login
2. **Account Management**: Add your bank accounts
3. **Transaction Entry**: Start recording income and expenses
4. **Investment Tracking**: Add your various investments
5. **Insurance Management**: Record insurance policies
6. **Analytics**: View reports and charts for financial insights

## Key Components

### Database Management
- `DBHelper.java` - Main database helper
- `SQLHelper.java` - SQL operations helper
- `Database.java` - Database operations

### Core Activities
- `MainActivity.java` - Main dashboard
- `Login.java` / `Registration.java` - User authentication
- `Dashboard.java` - Financial overview
- `navdraw.java` - Navigation drawer

### Financial Modules
- **Accounts**: `Account.java`, `AddAccount.java`, `UpdateAccount.java`
- **Transactions**: `AddTransaction.java`, `TransactionDetails.java`
- **Expenses**: `AddNewExpense.java`, `Expense.java`, `Edit_expense.java`
- **Investments**: Various investment-specific classes
- **Insurance**: Insurance management classes

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Screenshots

*Coming soon - Add screenshots of the app interface*

## Future Enhancements

- Cloud synchronization
- Multi-currency support
- Advanced reporting features
- Export functionality (PDF, Excel)
- Backup and restore features
- Biometric authentication

## Support

For support and questions, please open an issue on GitHub.

---

**Developed with ❤️ for better financial management**
