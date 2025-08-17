#include <stdio.h>
#include <math.h>
#include <stdlib.h>

struct employee {
    int id;
    char name[25];
    float salary;
};

struct node {
    struct employee data;
    struct node *next;
};
typedef struct node node;

node *makeNode() {
    struct employee s;
    printf("Enter ID number: ");
    scanf("%d", &s.id);
    fflush(stdin);
    printf("Enter employee name: ");
    gets(s.name);
    printf("Enter employee salaries: ");
    scanf("%f", &s.salary);
    node *newNode = (node*)malloc(sizeof(node));
    newNode->data = s;
    newNode->next = NULL;
}

void pushFront(node **head) {
    node *newNode = makeNode();
    newNode->next = *head;
    *head = newNode;
}

void pushBack(node **head) {
    node *newNode = makeNode();
    if (*head == NULL) {
        *head = newNode;
        return;
    } else {
        node *temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

void insert(node **head, int specific_location) {
    node *temp = *head;
    int i;
    for (i = 1; i <= specific_location - 2; i++) {
        temp = temp->next;
    }
    node *newNode = makeNode();
    newNode->next = temp->next;
    temp->next = newNode;
}

void browse(node *head) {
    while (head != NULL) {
        printf("ID: %d\t\t", head->data.id);
        printf("Name: %s\t\t", head->data.name);
        printf("Salary: %f\n\n", head->data.salary);
        head = head->next;
    }
}

// Check if the list is empty or not
int CheckList(node *head) {
    if (head == NULL) {
        return 1;
    }
    return 0;
}

int main() {
    node *head = NULL;
    int C_L = CheckList(head);
    if (C_L == 1) {
        printf("The list is currently empty\n");
    } else {
        printf("The list now has content inside\n");
    }

    int select;
    int specific_location;

    // Enter the first employee and put it at the beginning of the list.
    pushFront(&head);
    printf("\n******************************\n");
    browse(head);

    // Check if the user enters the first employee and then wants to continue entering the second employee or not
    int Y_N;
    printf("\nDo you want to continue entering again? \nChoose 1 for Yes\nChoose 0 for No ");
    printf("\nSelect (1/0): ");
    scanf("%d", &Y_N);
    if (Y_N == 0) {
        printf("\n                                              LIST OF EMPLOYEE\n");
        printf("\n-----------------------------------------------------------------------------------------------------------------------\n\n");
        browse(head);
    } else {
        int i;
        printf("\n******************************\n");
        for (i = 1; i <= 4; i++) {
            if (i == 1) {
                // Enter the second employee with only the first or last two positions
                printf("1. Add to the beginning\n");
                printf("2. Added at the end");
                printf("\nEnter the location you want to fill: ");
                scanf("%d", &select);
                printf("\n");
                if (select == 1) {
                    pushFront(&head);
                    printf("\n******************************\n");
                    browse(head);
                } else {
                    pushBack(&head);
                    printf("\n******************************\n");
                    browse(head);
                }
            } else {
                // From the third employee to the fifth employee there are 3 different positions
                printf("1. Add to the beginning\n");
                printf("2. Add in the middle\n");
                printf("3. Added at the end");
                printf("\nEnter the location you want to fill: ");
                scanf("%d", &select);
                printf("\n");

                if (select == 1) {
                    pushFront(&head);
                    printf("\n******************************\n");
                    browse(head);
                }
                if (select == 3) {
                    pushBack(&head);
                    printf("\n******************************\n");
                    browse(head);
                }
                if (select == 2) {
                    printf("The specific position you want to insert in the middle is: ");
                    scanf("%d", &specific_location);
                    insert(&head, specific_location);
                    printf("\n******************************\n");
                    browse(head);
                }
            }
            // Only enter a maximum number of 5 sets of employee records
            if (i == 4) {
                printf("\n                                              LIST OF EMPLOYEE\n");
                printf("\n-----------------------------------------------------------------------------------------------------------------------\n\n");
                browse(head);
                break;
            }

            // If there are less than 5 record sets and the user does not want to continue importing them
            printf("\nDo you want to continue entering again? \nChoose 1 for Yes\nChoose 0 for No ");
            printf("\nSelect (1/0): ");
            scanf("%d", &Y_N);
            if (Y_N == 0) {
                printf("\n                                              LIST OF EMPLOYEE\n");
                printf("\n-----------------------------------------------------------------------------------------------------------------------\n\n");
                browse(head);
                break;
            } else {
                printf("\n");
            }
        }
    }
    return 0;
}