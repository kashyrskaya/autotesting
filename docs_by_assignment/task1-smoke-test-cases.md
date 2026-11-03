# Task 1: Smoke Test Cases

## Target
- **URL**: [https://automationintesting.online/](https://automationintesting.online/) (Admin login section: `/admin`)
- **Credentials**: `admin` / `password`
- **Objective**: Functional test cases belonging to the smoke test to cover the login section.

---

## Test Cases Suite: Smoke Test - Admin Login

### TC-01 Verify navigation to Admin section and login form availability - P0

Precondition:
1. Browser cookies and session storage are cleared
2. Navigate to the {page URL}

| Test Step                                     | Expected Result                                                                    |
| --------------------------------------------- | ---------------------------------------------------------------------------------- |
| 1. Click Admin in the navigation header       | 1. The Admin section is loaded {page URL/admin}                                    |
| 2. Enter {invalid password} into the Password | 2. The Login form is rendered with Username input, Password input and Login button |
|                                               | is visible and enabled                                                             |

### TC-02 Verify admin login is successfull with valid credentials - P0

Precondition:
1. Browser cookies and session storage are cleared
2. Navigate to the {page URL}
3. Proceed to the Admin section {page URL/admin}
4. Login form is displayed

| Test Step                                | Expected Result                                       |
| ---------------------------------------- | ----------------------------------------------------- |
| 1. Enter {login} into the Username field | 1. User is redirected to the Admin                    |
| 2. Enter {password} into the Password    | Dashboard                                             |
| field                                    | 2. Rooms section is selected in the navigation header |
| 3. Click "Login" button                  |                                                       |

### TC-03 Verify navigation back to the public front page from the Admin login screen - P1

Precondition:
1. User is on the unauthenticated Admin Login page {page URL/admin}

| Test Step                                   | Expected Result                                     |
| ------------------------------------------- | --------------------------------------------------- |
| 1. Click the "Front Page" link (or "Restful | 1. User is navigated away from the Admin login view |
| Booker Platform Demo" brand link) in the    | 2. The public hotel home page is displayed          |
| top navigation header                       |                                                     |


