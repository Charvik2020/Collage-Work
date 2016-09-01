d=1:1:10^6;% Distance
p_t=1;   %Trasmitting Antena Power
G_t=1;   %Trasmitting Antena Gain
G_r=1;   %Receiving Antena Gain
c=3*10^8;   %Speed of light
f=900*10^6;  %frequency
lamda=c/f;
p_r=p_t.*G_t.*G_r.*(lamda./(4.*pi.*d)); %Recevier Antena Power
plot(log10(d),db(p_r)); %plot
xlabel('Distance -> log10(d)'); % X-Axis Label 
ylabel('Rec. Antena Power -> db(p_r)'); % Y-Axis Label
title('Free Space'); %Title