d = 1:0.1:100; % Distance
p_t=1;   %Trasmitting Antena Power
G_t=1;   %Trasmitting Antena Gain
G_r=1;   %Receiving Antena Gain
c=3*10^8;   %Speed of light
f=900*10^6;  %frequency
lamda=c/f;
h_t = 50; %Height of Transmiting Antena
h_r = 3; %Height of Receiving Antena
R=-1;   %Reflaction co-efficient
DeltaPhi=0; %Phase Diffrence
l=(sqrt((h_t-h_r)^2 + (d.^2)));   %Direct line of sight Ray path(lenght)
sum=0;

for i=1:9
t=0.1*i*d;
x=(sqrt((h_t).^2+(t.^2)));   %Reflacted Ray path(lenght)
x_1=(sqrt((h_r).^2+((d-t).^2)));   %Reflacted Ray path(lenght)
DeltaPhi=DeltaPhi+2.*pi.*((x+x_1)-l);  %Phase Different Between rays
sum = sum + R.*sqrt(G_r).*(exp(-1i.*(DeltaPhi))./(x+x_1));
end

p_r = p_t.*(c./(4.*pi*f)).^2.*(abs((sqrt(G_t)./l) + sum)).^2;    %Receiver Antena Power

plot(log10(d),10*log10(p_r)); %Plot
xlabel('Distance -> (log10(d))') %X-Axis Label
ylabel('Rec. Antena Power -> p_r(dB)') %Y-Axis Label
title('Ten Ray') %Title