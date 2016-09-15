BEGIN{
        while(1){
                printf "1. Basic Computation\n"
		printf "2. Trigonometric\n"; 
		printf "3. Logarithm\n"
		printf "4. Exponent\n";
		printf "5. Exit\n";
		printf "Enter your choice:";
                getline choice < "-";
                printf "\n"
                if(choice == 1)        #Basic Computation
                {
                        printf "1. Add\n2. Subtract\n3. Multiply\n4. Divide\nEnter your choice:";
                        getline choice < "-";
                        printf "Enter number 1:";
                        getline number1 < "-";                              
                        printf "Enter number 2:";
                        getline number2 < "-";
                        printf "\n"
                        if(choice == 1)
			{
			    print "Sum:";
                            print number1 + number2;
			}
                        if(choice == 2)
			{
			    print "Subtract:";
                            print number1 - number2;
			}
                        if(choice == 3)
			{
			    print "Multiply:";
                            print number1 * number2;
			}
                        if(choice == 4)
			{
			    print "Divide:";
                            print number1 / number2;
			}
                  }
                else if(choice == 2)    #Trigonometry
                {
                        printf "1. sin\n2. cos\n3. tan\n4. cot\n5. sec\n6. cosec\nEnter your choice:";
                        getline choice < "-";
                        printf "Enter number(in Radian): ";
                        getline number1 < "-"; 
                        printf "\n"                            
                        if(choice == 1)
                            print "Sin("number1")="sin(number1);
                        if(choice == 2)
                            print "Cos("number1")="cos(number1);
                        if(choice == 3)
                            print "Tan("number1")="sin(number1)/cos (number1);
                        if(choice == 4)
                            print "Cot("number1")="cos(number1)/sin(number1);
                        if(choice == 5)
                            print "Sec("number1")="1/cos(number1);
                        if(choice == 6)
                            print "Cosec("number1")="1/sin(number1);
                        printf "\n"
                }
                else if(choice == 3)    #Logarithms
                {
                        printf "Enter Base:";
                        getline base < "-";
                        printf "Enter number:";
                        getline number < "-";
                        print "log"base"("number")="log(number)/log(base);
                        printf "\n"
                }
                else if(choice == 4)    #Exponent
                {
                        printf "Enter number:";
                        getline number < "-";
                        print "exp("number")="exp(number);
                        printf "\n"
                }
                else if(choice == 5)    #Exit
                        exit(0);
        }
}
