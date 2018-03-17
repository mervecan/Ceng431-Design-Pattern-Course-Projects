# CENG431 – Building Software Systems

In this homework you are expected to implement a “ **_Hospital Dispatch and Monitor System_** ” in Java.

You should fulfill the concepts of;

- Inheritance
- Polymorphism
- Abstract Data Type
- Collections
- Generics
- Mediator Pattern

Your Hospital Dispatch and Monitor System should be your **Mediator** and responsible of;

- Monitoring Patients.
- Monitoring Hospital Staff (Doctors, Nurses and Patient Companion).
- Redirecting a Hospital Staff to Patients Room according to Patient needs.
- Assigning a task to a hospital staff that they should take action.

Doctors, Nurses and Patient Companions can have common interactions like going to patient’s room and
taking actions on patient. However, actions could vary according the **Hospital Staff** type. For example,
specific **tasks** that could only be done by a specific Hospital Staff are given below:

- Doctors can:
    o Perform operation.
    o Perform visit.
    o Dismiss from hospital.
- Nurses
    o Bring medicine to patient.
    o Take blood sample.
- Patient Companion
    o Take patient to MRI
    o Take patient to X-Ray

Assume that tasks are completed immediately and one of the “SUCCESS” or “FAILURE” **results** are
returned to the Mediator. Results will be randomly determined. Probabilities for result of each task
should be determined before execution and passed to the program using a file. Tasks are selected using
the console by the user.
