d=1:1:10^6;% Distance
p_t=1;   %Trasmitting Antena Power
G_t=1;   %Trasmitting Antena Gain
G_r=1;   %Receiving Antena Gain
c=3*10^8;   %Speed of light
f=900*10^6;  %frequency
lamda=c/f; %wavelenght
h_t = 50; %Height of Transmiting Antena
h_r = 3; %Height of Receiving Antena
R=-1;   %Reflaction co-efficient

xx_1=(sqrt((h_t+h_r)^2+d.^2));%Reflacted Ray Path(lenght) 
l=(sqrt((h_t-h_r)^2+d.^2)); %Direct line of sight Ray path(lenght)
DeltaPhi=2.*pi.*(xx_1 - l); %the phase difference between the two received signal components
p_r=p_t*(lamda./(4.*pi)).^2.*abs(1./l + R.*exp(-1j.*DeltaPhi)./xx_1).^2; %Reciever Antena Power

plot(log10(d),db(p_r)); %plot
xlabel('Distance -> log10(d)'); %X-Axis Label
ylabel('Rec. Antena Power -> db(p_r)'); %Y-Axis Label
title('Two Ray'); %Title