c=3*10^8;%speed of light
lamda=c./f;%wavelenght
d=50*10^3;%distance between two antenna
h_b= 100;%hieght of transmiting Basestation antenna
h_m= 3;%hieght of recieving mobilestation antenna
g_hte=20*log10(h_b/200);%gain of transmiting antenna
f=[100*10^7,90*10^7,80*10^7,70*10^7,60*10^7,50*10^7,40*10^7,30*10^7,20*10^7,10*10^7];%freq.
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
    if (f(i)<300)
        cHl = 8.29*(log10(1.54*h_m))^2 - 1.1 ;%antenna hieght correlation factor
    else
        cHl=3.2 * (log10(11.75*h_m))^2 - 4.97;%antenna hieght correlation factor
    end
end
CH= 0.8 + (1.1.*log10(f) - 0.7)*h_m - 1.56.*log10(f);%antenna hieght correlation factor openarea
Luo  = 69.55+26.16.*log10(f)-13.82*log10(h_m)-CH +(44.9- 6.55*log10(h_m))*log10(d);%pathloss in urban area for small size city
Lu= 69.55 + 26.16.*log10(f) - 13.82*log10(h_b) - cHl + (44.9 - 6.55*log10(h_b))*log10(d);%pl in urban areas in dB
Lsu = Lu - 2.*(log10(f./28)).^2 -5.4;%pl in sub-urban area in city
Lo=Luo - 4.78.*(log10(f)).^2 + 18.33.*log10(f) - 40.94;%pl in open area 
plot(f,Lu,f,Lsu,'--',f,Lo,':');%plot
title('Hata Model (frequency->pathloss)');
xlabel('frequency ->');
ylabel('pathloss(dB)->');
legend('urban','sub-Urban','openArea');
