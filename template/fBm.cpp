//for each pixel, get the value
total = 0.0f;
frequency = 1.0f/(float)octaves;
amplitude = gain;
                
for (i = 0; i < octaves; ++i)
{
    total += noise(
        (float)x * frequency,
        (float)y * frequency
    ) * amplitude;         
    frequency *= lacunarity;
    amplitude *= gain;
}
                        
//now that we have the value, put it in
map[x][y]=total;