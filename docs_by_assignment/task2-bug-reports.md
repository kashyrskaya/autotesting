# Task 2: Bug Reports & Enhancements

## Target
- **URL**: [https://automationintesting.online/](https://automationintesting.online/)
- **Objective**: Find two defects (or propose two enhancements) observing the application and write appropriate bug reports using standard professional templates.

---

## Bug Report / Enhancement #1

- **Report ID**: BUG-001 
- **Title**: Sensitive admin dashboard data is exposed via browser back navigation after logout (Cache Leak)
- **Type**: Bug
- **Severity**: High
- **Priority**: High 
- **Environment**: macOS / Chrome 130 / Production (`https://automationintesting.online/`)
- **Preconditions**:
  - Browser cookies and session storage are cleared initially
  - User logs in as an Admin with valid credentials
  - User is on the Admin Dashboard view

### Steps to Reproduce
1. From the Admin Dashboard click "Log out" button in the top navigation section
2. User is returned to the main page (public view)
3. Click the browser's "Back" navigation button
4. Observe the rendered view and attempt to refresh the page

### Expected Result
- The user is treated as unathenticated
- Navigating back does not restore authenticated view and does not reveal information available only to Admin
- The application evaluates authentication state and blocks access to Admin data or prompts to reauthenticate

### Actual Result
- The browser restores a cached DOM snapshot 
- The last viewed Admin page is rendered and fully visible to any subsequent user on the device without re-authentication


### Proposed Fix / Recommendation
- Serve the application and authenticated resources with anti-caching directives to instruct the browser not to persist DOM snapshots of authenticated routes

---

## Bug Report / Enhancement #2

- **Report ID**: BUG-002 
- **Title**: "Logout" button is visible and active on the Admin Login page for unauthenticated users
- **Type**: Bug 
- **Severity**: Trivial
- **Priority**: Low
- **Environment**: macOS / Chrome 130 / Resolution: 1920x1080 / Production (`https://automationintesting.online/`)
- **Preconditions**:
  - Browser cookies and session storage are cleared initially
  - Navigate to the Admin login page {pageURL/admin}
  - Admin login form is displayed

### Steps to Reproduce
1. Observe the top-right navigation header while on the login page
2. Click the "Logout" button

### Expected Result
- The "Logout" action is available only when an active, authenticated admin user session exists
- On the public login view the top navigation displays only relevant public links

### Actual Result
- The "Logout" button is visible and interactable in the navigation header when no user is authenticated
- Clicking "Logout" navigates the user back to the main page without performing any meaninglfull session invalidation


### Proposed Fix / Recommendation
- Conditionally render the Logout button based on client authentication state
