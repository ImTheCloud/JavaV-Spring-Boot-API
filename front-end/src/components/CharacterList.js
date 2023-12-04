import React, { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import {
    Card,
    CardContent,
    Typography,
    List,
    ListItem,
    ListItemText,
    Grid,
    CircularProgress,
    TextField,
    InputAdornment,
    IconButton,
    Button,
} from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import backgroundImage from '../images/onepiece.jpeg';

const CharacterList = () => {
    const [characters, setCharacters] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [searchTerm, setSearchTerm] = useState('');
    const charactersRef = useRef(null);

    useEffect(() => {
        axios
            .get('http://localhost:8080/api/characters')
            .then((response) => {
                setCharacters(response.data);
                setLoading(false);
            })
            .catch((error) => {
                setError('Error fetching characters');
                setLoading(false);
            });
    }, []);


    const filteredCharacters = characters.filter((character) =>
        character.name.toLowerCase().includes(searchTerm.toLowerCase())
    );

    const scrollToCharacters = () => {
        charactersRef.current.scrollIntoView({ behavior: 'smooth' });
    };

    return (
        <div>
            {/* Section d'accueil */}
            <div
                style={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    justifyContent: 'center',
                    padding: '20px',
                    backgroundImage: `url(${backgroundImage})`,
                    backgroundSize: 'cover',
                    backgroundPosition: 'center',
                    minHeight: '100vh',
                }}
            >
                <Typography variant="h1" gutterBottom style={{ color: '#fff', marginBottom: '20px' }}>
                    One Piece API
                </Typography>

                {loading && <CircularProgress style={{ color: '#fff', marginBottom: '20px' }} />}
                {error && <Typography variant="h5" style={{ color: '#fff', marginBottom: '20px' }}>{error}</Typography>}

                {/* Bouton Documentation */}
                <Button variant="outlined" color="primary" onClick={scrollToCharacters} style={{ marginBottom: '20px' }}>
                    CHARACTERS
                </Button>
            </div>

            {/* Section des caractères */}
            <div ref={charactersRef}>
                <Grid container spacing={3} justifyContent="center" style={{ background: 'linear-gradient(to right, rgba(60, 0, 0, 0.9), rgba(210, 105, 30, 0.9))' }}>
                    {filteredCharacters.map((character) => (
                        <Grid item key={character.id} xs={12} sm={6} md={4} lg={3}>
                            <Card style={{ background: 'rgba(255, 255, 255, 0.8)', width: '100%' }}>
                                {/* Rank en plus grand et centré */}
                                <Typography variant="h3" style={{ textAlign: 'center', marginBottom: '10px' }}>
                                    {character.name}
                                </Typography>

                                <CardContent>
                                    <div style={{ textAlign: 'center', marginBottom: '10px', position: 'relative' }}>
                                        {character.imageUrl && (
                                            <div
                                                style={{
                                                    backgroundImage: `url(${character.imageUrl})`,
                                                    backgroundSize: 'cover',
                                                    backgroundPosition: 'center',
                                                    width: '100%',
                                                    height: '250px',
                                                    borderRadius: '8px',
                                                }}
                                            />
                                        )}
                                    </div>

                                    <List>
                                        <Typography variant="h5" style={{ textAlign: 'center', marginBottom: '10px' }}>
                                            {character.rank}
                                        </Typography>
                                        <ListItem>
                                            <ListItemText primary={`Job: ${character.job || 'N/A'}`} />
                                        </ListItem>
                                        <ListItem>
                                            <ListItemText primary={`Bounty: ${character.bounty || 'N/A'}`} />
                                        </ListItem>
                                        <ListItem>
                                            <ListItemText primary={`Devil Fruit: ${character.devilFruit ? `${character.devilFruit.nameFruit} ` : 'N/A'}`} />
                                        </ListItem>
                                        <ListItem>
                                            <ListItemText primary={`Crew: ${character.crew ? character.crew.nameCrew : 'N/A'}`} />
                                        </ListItem>
                                        <ListItem>
                                            <ListItemText primary={`Haki: ${character.haki ? character.haki.nameHaki : 'N/A'}`} />
                                        </ListItem>
                                        <ListItem>
                                            <ListItemText primary={`Fight Tactics: ${character.fightTactics ? `${character.fightTactics.nameTactics} ` : 'N/A'}`} />
                                        </ListItem>
                                    </List>
                                </CardContent>
                            </Card>
                        </Grid>
                    ))}
                </Grid>
            </div>
        </div>
    );
};

export default CharacterList;
