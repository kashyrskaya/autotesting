# Task 1: Smoke Test Cases

## Target
- **URL**: [https://automationintesting.online/](https://automationintesting.online/) (Admin login section: `/admin`)
- **Credentials**: `admin` / `password`
- **Objective**: Functional test cases belonging to the smoke test to cover the login section.

---

## Test Cases Suite: Smoke Test - Admin Login

Preconditions (shared for all TCs):
1. Browser cookies and session storage are cleared
2. Navigate to the {page URL}
3. Proceed to the Admin section {page URL/admin}
4. Login form is displayed

### TC-01 Verify admin login is successfull with valid credentials - P0

| Test Step                                | Expected Result                                       |
| ---------------------------------------- | ----------------------------------------------------- |
| 1. Enter {login} into the Username field | 1. User is redirected to the Admin                    |
| 2. Enter {password} into the Password    | Dashboard                                             |
| field                                    | 2. Rooms section is selected in the navigation header |
| 3. Click "Login" button                  |                                                       |
| 4. Click "Logout" button in the          | 3. User is returned to the main                       |
| navigation header                        | page on {pageURL}                                     |

### TC-02 Verify authentication rejection with invalid credentials - P1

| Test Step                                     | Expected Result                               |
| --------------------------------------------- | --------------------------------------------- |
| 1. Enter {login} into the Username field      | 1. User remains on the admin section {/admin} |
| 2. Enter {invalid password} into the Password |                                               |
| field                                         |                                               |
| 3. Click "Login" button                       | 2. "Invalid credentials" message is displayed |

