# JavaWorks

Repository which collects Java works ranging from the basics to high-performance concurrent tasks.

- BASIC JAVA: As the name suggests, this folder contains basic Java code.

    +HelloWorld.java: The first slope in every programming language.

    +Random.java: A brief example of usage of the command line parameters.

    +Cesar.java: Codifies a String using the Cesar method.

    +Complex.java / usingComplex.java: Abstraction and usage example of complex numbers.

    +Patient.java / usingPatient.java: Abstraction and usage example of a hospital's database (using only Java).

- CONCURRENCY: This folder contains sample codes for basic Java concurrency problems that escalate on complexity and use different approaches.

    +scaleVectorParallel.java: Completely parallelizable problem which it hasn't got critical region*1. Usage of simple Thread inheritance: most basic form of co-routine.
    
    +BankAccount.java / ATM.java / usingATM.java: Abstraction and usage of an automated teller machine. Usage of the Runnable interface, which models a task to later be input to a Thread object, which runs it as a co-routine. Intended race conditions to occur.

    +MatVectorParThick.java / usingMatVectorParThick.java: Completely parallelizable problem which hasn't got critical region. Usage of the Runnable interface, which models a task to later be input to a Thread object, which runs it as a co-routine. Task is optimized to fit the number of processors available.


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    1. Part of the code where race conditions take place, i.e. there's a shared resource between several co-routines which can be accessed simultaneously, provoking unpredictable results. Control of the mutual exclusion strives to solve these problems.