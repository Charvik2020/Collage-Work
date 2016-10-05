%No ISI | doppler shift
t = [0, 1, 2, 5]*10^-6; % sample time 
p_dB = [-10, -20, -20, -30]; % power in dB
p_W = 10.^(p_dB/10); % power in watt
t_m = sum(p_W.*t)./sum(p_W); 
t_m_sqr = sum(p_W.*t.^2)./sum(p_W); 
sigma_t = sqrt(t_m_sqr - (t_m)^2); % average delay spread
v = 500*5/18; % velocity in m/s
fc = 128*10^6; % carrier frequency
lambda = 3*10^8/fc;
theta = 310*180/pi;%convert to degre
fd = v*cos(theta)/lambda; % doppler shift
chan = rayleighchan(10^-5, fd, t, p_dB);
tx = randsrc(10^3, 1, [-1, 1]);
fad_channel = filter(chan, tx);
eyediagram(fad_channel, 5);
title('No ISI | Doppler Shift');