%No ISI | No doppler shift
t = [0, 1, 2, 5]*10^-6; % sample time 
p_dB = [-10, -20, -20, -30]; % power in dB
p_W = 10.^(p_dB/10); % power in watt
t_m = sum(p_W.*t)./sum(p_W); 
t_m_sqr = sum(p_W.*t.^2)./sum(p_W); 
sigma_t = sqrt(t_m_sqr - (t_m)^2); % average delay spread
chan = rayleighchan(10^-5, 0, t, p_dB);
tx = randsrc(10^3, 1, [-1, 1]);
fad_channel = filter(chan, tx);
eyediagram(fad_channel, 5);
title('No ISI | No Doppler Shift');