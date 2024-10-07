UploadDownload Automation Test
This repository contains a Selenium automation test for uploading and downloading Excel files, modifying their contents using Apache POI, and verifying changes on a web page. The test is designed to interact with the test page at Rahul Shetty Academy's upload/download test page.

Features
Download a file: Automates downloading an Excel file from the web page.
Edit the Excel file: Updates specific cells in the downloaded Excel file using Apache POI.
Upload the modified file: Uploads the modified Excel file back to the web page.
Validate the success message: Waits for a toast notification and verifies its message.
Verify updated data: Ensures that the updated data is displayed correctly on the web page.
Technologies Used
Java: Core programming language.
Selenium WebDriver: For browser automation.
Apache POI: For reading and writing Excel files.
TestNG: For assertions and testing framework.
Prerequisites
Before running the test, ensure that you have the following installed:

Java JDK (version 11 or above)
Maven (to manage dependencies and run the test)
ChromeDriver (compatible with the installed version of Chrome)
Apache POI library for Excel file manipulation
