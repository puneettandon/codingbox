Expense Sharing/Bill Sharing Design

- Allows App to share an expense
    -  Users will be able to organize expenses among multiple head and share with multiple users.
    - Users can create a group
    - Share an expense among members of the group.
    - Send notifications to on their share to be paid.
    - Add bank details for transfer of amount.
    - Track paid users.
    
- Use Cases 
    - Users should be able to register
    - User creation is idempotent.
    - Registered user should be able to create an expense.Expense has 3 states.
        1. Created.
        2. Pending
        3. Settled
    - Initial State of the expense would be created.
    - Registered User should be able to create expense group i.e. to be able to add users to expense
    - Bifurcation is custom no need to implement equal sharing.Once the bifurcation is complete 
      the expense state becomes pending.
    - Provision to extend provide user notification when someone adds them to the expense.
    - Users should be able to add their contribution.
    - Once the settlement is complete from all the users the expense should become settled.
    - Any number of users should be able to create expenses at the same time.
    - One user should be able to create more than one expense and share it with different set of users.s
    - Expense creator should be able to track their expenses and payments made by users.
    - Users can settle expenses in parts
    

- The Solution should be extendable
- No need to persist in database.Data can be stored in memory.

