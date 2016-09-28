SNR = 0.5:0.5:10; % snr value
Tx=randsrc(10^5,1,[0,1]); % generate 10^5 number of bit
Ts=1/10^5; % time period
Ray_chan = rayleighchan(Ts,0); % generate rayleigh channel
mod_handler = modem.pskmod('M',4,'InputType','bit'); %M=4 becouse 4-QPSK modulation
dem_handler = modem.pskdemod('M',4,'OutputType','bit','DecisionType','hard decision');%M=4 becouse 4-QPSK De-modulater
QPSK = modulate(mod_handler,Tx); % Modulate Signal
filter_signal = filter(Ray_chan,QPSK); % Geting Filter Signal

for i=SNR
    
    N = awgn(filter_signal,i); % Adding Noise to Filter
    Rx = demodulate(dem_handler,N); % De-modulate Received Signal
    SER(i*2) = biterr(Tx,Rx); %Find Bit Error
end
semilogy (SNR , SER/10^5);
title('Bit Error Rate -> SNR (QPSK) ');

xlabel('SNR->');
ylabel('BER(dB)->');



