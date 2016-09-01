c=3*10^8;%speed of light
f=900*10^6;%distance between two antenna
lamda=c./f;%wavelenght
h_b= 100;%hieght of transmiting Basestation antenna
h_m= 3;%hieght of recieving mobilestation antenna
g_hte=20*log10(h_b/200);%gain of transmiting antenna
d=[100*10^3,90*10^3,80*10^3,70*10^3,60*10^3,50*10^3,40*10^3,30*10^3,20*10^3,10*10^3];%freq.
amu=[47.2,46.4,45.5,45,44,42,41.5,41.1,39,37];%correlation factor
Garea=[30,28.5,28.25,28,27.2,26.6,25,24,23.5,22];%Correlation factor for diff. envierment
g_hre=0;
if ( h_m <3 )
    g_hre=10*log10(h_m/3);% gain of recieving antenna
else if( h_m>3 && h_m<10)
        g_hre=20*log10(h_m/3);% gain of recieving antenna
    end
end
chl=zeros(1,10);%making an array
for i=1:10
    if (f<300)
        cHl = 8.29*(log10(1.54*h_m))^2 - 1.1 ;%antenna hieght correlation factor
    else
        cHl=3.2 * (log10(11.75*h_m))^2 - 4.97;%antenna hieght correlation factor
    end
end
CH= 0.8 + (1.1*log10(f) - 0.7)*h_m - 1.56*log10(f);%antenna hieght correlation factor openarea
Luo  = 69.55+26.16*log10(f)-13.82*log10(h_m)-CH +(44.9- 6.55*log10(h_m)).*log10(d);%pathloss in urban area for small size city
Lu= 69.55 + 26.16*log10(f) - 13.82*log10(h_b) - cHl + (44.9 - 6.55*log10(h_b)).*log10(d);%pl in urban areas in dB
Lsu = Lu - 2*(log10(f/28))^2 -5.4;%pl in sub-urban area in city
Lo=Luo - 4.78*(log10(f))^2 + 18.33*log10(f) - 40.94;%pl in open area 
plot(d,Lu,'--',d,Lsu,d,Lo,':');
title('Hata Model (Distance->pathloss)');
xlabel('Distance ->');
ylabel('pathloss(dB)->');
legend('urban','sub-Urban','openArea');
