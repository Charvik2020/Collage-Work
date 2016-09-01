c=3*10^8;%speed of light
f=900*10^6;%freq.
lamda=c/f;%wavelenght

h_t= 100;%hight of transmiting antenna
h_r= 10;%hight of receving antenna
g_hte=20*log10(h_t/200);%gain of transmiting antena 
d=[100*10^3,90*10^3,80*10^3,70*10^3,60*10^3,50*10^3,40*10^3,30*10^3,20*10^3,10*10^3];
amu=[58 , 55 , 53 , 52 , 46 , 43 , 38 , 33 , 28 , 26];
Garea=9;
g_hre=0;

if ( h_r <3 )
    then 
    g_hre=10*log10(h_r/3);%gain of recieving antena
    
else if( h_r>3 && h_r<10)
        then
        g_hre=20*log10(h_r/3);%gain of Recieving antena
    end
end


lf= 10*log10((4*pi)^2.*d.^2/lamda^2);%free space prapogation loss
lfifty=lf + amu-g_hte-g_hre-Garea;%50% path loss in dB

plot(d,lfifty);%plot
title('Okumura model (distance->pathloss)');
xlabel('Distance ->');
ylabel('pathloss(dB)->');

