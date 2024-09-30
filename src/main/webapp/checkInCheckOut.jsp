<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Check-in/out</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
        }
        input, select {
            margin-top: 5px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }
        button {
            margin-top: 20px;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .date-time-group {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }
        .date-time-group > div {
            flex: 1;
            margin-right: 10px;
        }
        .date-time-group > div:last-child {
            margin-right: 0;
        }
        .id-proof-group {
            display: flex;
            justify-content: space-between;
            align-items: flex-end;
            margin-bottom: 10px;
        }
        .id-proof-group > div {
            flex: 1;
            margin-right: 10px;
        }
        .id-proof-group > div:last-child {
            margin-right: 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer Check-in/out</h1>
        <form action="checkinandout" method="post">
            <label for="name">Customer Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required>

            <div class="id-proof-group">
                <div>
                    <label for="id-type">ID Proof Type:</label>
                    <select id="id-type" name="idType" required>
                        <option value="">Select ID Type</option>
                        <option value="aadhaar">Aadhaar Card</option>
                        <option value="driving-license">Driving License</option>
                        <option value="voter-id">Voter ID</option>
                        <option value="passport">Passport</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <div>
                    <label for="id-number">ID Number:</label>
                    <input type="text" id="id-number" name="idNumber" required>
                </div>
            </div>

            <div class="date-time-group">
                <div>
                    <label for="check-in-date">Check-in Date:</label>
                    <input type="date" id="check-in-date" name="checkInDate" required>
                </div>
                <div>
                    <label for="check-in-time">Check-in Time:</label>
                    <input type="time" id="check-in-time" name="checkInTime" required>
                </div>
            </div>

            <div class="date-time-group">
                <div>
                    <label for="check-out-date">Check-out Date:</label>
                    <input type="date" id="check-out-date" name="checkOutDate" required>
                </div>
                <div>
                    <label for="check-out-time">Check-out Time:</label>
                    <input type="time" id="check-out-time" name="checkOutTime" required>
                </div>
            </div>

            <button type="submit" value="submit">Submit</button>
        </form>
    </div>
</body>
</html>