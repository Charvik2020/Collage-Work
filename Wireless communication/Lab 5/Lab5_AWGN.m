%AWGN
%making Array
n = zeros(1,10^5);
Ysym = zeros(1,10^5);
Y = zeros(1,10^5);
count=0;
%generating rando Symbols of X and Y and storing in Array
Xsym1 = (randi([0,1],1,10^5));
Xsym2 = (randi([0,1],1,10^5));
X = (2.*(Xsym1) - 1) + 1j*(2.*(Xsym2)-1);
X1=X/sqrt(2);

for SNR=1:10
    count =0;
    Var = 10.^(-SNR/20);
    n = (Var./sqrt(2)).*(randn(1,10^5)+ 1j.*randn(1,10^5));
    
    Y = X1 + n;%recieved Signal
    for i=1:1:10^5
        
         if real(Y(i))<0 && imag(Y(i))<0
            Ysym(i) = -1 - 1*j;
        elseif real(Y(i))>0 && imag(Y(i))<0
            Ysym(i) = 1 - 1*j;
        elseif real(Y(i))<0 && imag(Y(i))>0
            Ysym(i) = -1 + 1*j;
        elseif real(Y(i))>0 && imag(Y(i))>0
            Ysym(i) = 1 + 1*j;
        end
      
        if(X(i)~=Ysym(i))% detecting no. of error in recieved Signal
            count=count+1;
        end
        
    end
    
    ser(SNR)=count/10^5;% Prob. Error 
end
%theoretical Computation
SNR=1:10;
SNR_linear=10.^(SNR./10);%converting dB to Linear
PE=erfc(sqrt(SNR_linear.*0.5))-0.25.*erfc(sqrt(0.5.*SNR_linear)).^2;%Theoretical Equation
semilogy(SNR,ser,SNR,PE);
title('SER vs SNR(AWGN Channel)');
xlabel('SNR(dB)->');
ylabel('SER->');
legend('Practical','Theoretical'); 