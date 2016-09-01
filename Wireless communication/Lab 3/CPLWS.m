%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%plot 1. COMBINED PATH LOSS WITH SHADOWING & SIMPLIFIED PATHLOSS
%plot 2. OUTRAGE PROBABILITY
lamda=0.333;%wavelenght
k=-31.53;
gamma=3.709;%pathloss exponetial
var=13.71;%variance of gaussian distribution
d=1:10:1000;
d_o=1;
p_t=1;
p_r=p_t+(k)-10*gamma*log10(d/d_o)-normrnd(0,sqrt(var),size(d));%recieving power at distance d in dB
p_min=-110.5;%minimum power in dBm
p_tp=10*10^-3;%Transmit power in mW
p=1-qfunc(((p_min-(p_tp+k-10*gamma*log10(d/d_o)))/sqrt(var)));%outrange probability
p_simpli = p_t + k - 10*gamma*log10(d/d_o);%simplified pathloss
subplot(2,1,1);
plot(d,p_r,d,p_simpli,'--');
legend('Combine pathloss with shadowing','simplified pathloss');
xlabel('distance ->');
ylabel('recieving power -> ');
title('COMBINED PATH LOSS WITH SHADOWING ');
subplot(2,1,2);
plot(d,p);
xlabel('distance -> ');
ylabel('probability ->');
title('OUTRAGE PROBABILITY');






