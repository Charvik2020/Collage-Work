c=3*10^8;%speed of light
lamda=c./f;%wavelenght
d=50*10^3;%distance between two antenna
h_t= 100;%hieght of transmiting antenna
h_r= 3;%hieght of recieving antenna
g_hte=20*log10(h_t/200);%gain of transmiting antenna
f=[100*10^7,90*10^7,80*10^7,70*10^7,60*10^7,50*10^7,40*10^7,30*10^7,20*10^7,10*10^7];%freq.
amu=[47,46,45.5,45,44,42,41.5,41,39,37];%correlation factor
Garea=[30,28.5,28.25,28,27,26,25,24,23.5,22];%Correlation factor for diff. envierment
g_hre=0;

if ( h_r <3 )
    then 
    g_hre=10*log10(h_r/3);% gain of recieving antenna
    
else if( h_r>3 && h_r<10)
        then
        g_hre=20*log10(h_r/3);% gain of recieving antenna
    end
end

lf= 10*log10((4*pi)^2.*d.^2./lamda.^2);%free space prapogation loss
lfifty=lf + amu - g_hte - g_hre - Garea;%50% path loss in dB
plot(f,lfifty);%plot
title('Okumura model (frequency->pathloss)');
xlabel('Frequency ->');
ylabel('pathloss(dB)->');

