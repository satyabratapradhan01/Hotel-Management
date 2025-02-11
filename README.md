# Hotel Management System - Advanced Java Project

## Overview

This project is a **Hotel Management System** developed using **Advanced Java** technologies, including **Servlets**, **JSP**, and **MySQL** for database management. The system allows administrators, owners, and customers to manage hotel bookings, customer details, and other related operations efficiently.

---

## Features

### 1. **Admin Module**
   - **Admin Login**: Admins can log in to the system using their credentials.
   - **Manage Bookings**: Admins can view, edit, and delete customer bookings.
   - **Manage Customers**: Admins can view, edit, and delete customer details.
   - **Manage Admins**: Admins can add, edit, and delete other admin accounts.

### 2. **Owner Module**
   - **Owner Login**: Owners can log in to the system using their credentials.
   - **Manage Admins**: Owners can view, edit, and delete admin accounts.
   - **Manage Bookings**: Owners can view and manage customer bookings.

### 3. **Customer Module**
   - **Customer Registration**: Customers can register themselves in the system.
   - **Customer Login**: Customers can log in to view their bookings and profile.
   - **Book Rooms**: Customers can book rooms by providing necessary details.
   - **Edit Profile**: Customers can edit their profile information.

### 4. **Booking Management**
   - **Check-In/Check-Out**: Customers can provide check-in and check-out details.
   - **Room Type Selection**: Customers can select room types during booking.
   - **Booking History**: Customers can view their booking history.

---

## Technologies Used

- **Frontend**: HTML, CSS, JavaScript, JSP
- **Backend**: Java Servlets
- **Database**: MySQL
- **Server**: Apache Tomcat
- **Other Tools**: JDBC for database connectivity

---

## Database Schema

The database `hotel_management` contains the following tables:

1. **admins**: Stores admin details.
   - `id`, `adminName`, `username`, `password`

2. **customer**: Stores customer details.
   - `coutomer_id`, `coutomer_name`, `coutomer_phnone_num`, `email`, `password`, `username`

3. **checkinandcheckout**: Stores booking details.
   - `SL_NO`, `Customer_Name`, `Email_Address`, `Phone_Number`, `ID_Proof_Type`, `ID_Number`, `Check_In_Date`, `Check_In_Time`, `Check_Out_Date`, `Check_Out_Time`, `place`, `room_type`, `username`, `status`

4. **owner**: Stores owner details.
   - `id`, `username`, `password`

---

## Project Structure

```
src/
├── com.jsp.admin/
│   ├── CoustomerEditScreen.java
│   ├── customerBooking.java
│   ├── CustomerDeleteServlete.java
│   ├── CustomerEditServlet.java
├── com.jsp.controller/
│   ├── AdminLoginServlet.java
│   ├── BookingServlet.java
│   ├── CheckInAndOut.java
│   ├── CheckUsernameServlet.java
│   ├── Costlogin.java
│   ├── Custsignup.java
│   ├── RoomType.java
│   ├── ServlateDashboard.java
├── com.jsp.customer.authentication/
│   ├── UserDeleteServlet.java
│   ├── UserEditServlet.java
│   ├── userRegistration.java
├── com.jsp.owner/
│   ├── AdminDataEntry.java
│   ├── AdminDeleteServlet.java
│   ├── adminDetelse.java
│   ├── AdminEditScreen.java
│   ├── AdminEditServlet.java
│   ├── OwnerLogin.java
WebContent/
├── adminDashboard.jsp
├── admin.jsp
├── checkInCheckOut.jsp
├── checkInSuccessfully.jsp
├── CustomerLogin.jsp
├── dashboard.jsp
├── newhome.html
├── newhome2.jsp
├── ownerdashboard.jsp
├── owner.jsp
├── profile.jsp
├── signup.html
├── usernameEntry.jsp
```

---

## How to Run the Project

1. **Set Up MySQL Database**:
   - Create a database named `hotel_management`.
   - Import the provided SQL schema and tables.

2. **Configure Database Connection**:
   - Update the database connection details in each servlet file:
     ```java
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "1234");
     ```

3. **Deploy the Project**:
   - Deploy the project on an Apache Tomcat server.
   - Ensure all dependencies (e.g., MySQL JDBC driver) are included in the `lib` folder.

4. **Access the Application**:
   - Open a browser and navigate to the application URL (e.g., `http://localhost:8080/HotelManagementSystem`).

---

## Screenshots

1. **Admin Dashboard**:
   - View and manage bookings, customers, and admins.

2. **Customer Booking Page**:
   - Customers can book rooms and provide check-in/check-out details.

3. **Owner Dashboard**:
   - Owners can manage admins and view bookings.

---

