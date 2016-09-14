%Rayleigh
%making Array
Xsym = zeros(1,10^5);
Ysym = zeros(1,10^5);
X = zeros(1,10^5);
n = zeros(1,10^5);
Y = zeros(1,10^5);

for SNR=1:10
    Var = 10^(-SNR/20);
    
    for i=1:1:10^5
        Xsym(i) = (randi([0,1])); %random number genrater either 0 / 1
        X(i) = 2*(Xsym(i)) - 1;%get value -1 / 1 (BPSK)
        n(i) = (1/sqrt(2))*(randn(1,1)+ randn(1,1)*1j)*Var;%noise of output
        h = (1/sqrt(2))*(randn(1,1)+ randn(1,1)*1j);%Coefficent factor 
        Y(i) = h.*X(i) + n(i);%Practical output signal
        Y(i)=Y(i)./(h);
        if  real(Y(i))<0%convert recieve symbol in binery
            Ysym(i)=0;
        else
            Ysym(i)=1;
        end   
    end      
    
    err_bit = xor(Xsym,Ysym);%to find error
    BER(SNR) = (sum(err_bit)/10^5);%bit error ratio
end
SNR=1:10;%snr values
SNR_linear=10.^(SNR./10);%convert SNR dB to Linear form
PE=((1-sqrt(SNR_linear./(1+SNR_linear))))/2;%theoretical output signal
semilogy(SNR,BER,SNR,PE);%plot
xlabel('SNR(dB)->');
ylabel('BER->');
legend('Practical','theoretical');
title('Wireless Channel BER(Rayleigh)');