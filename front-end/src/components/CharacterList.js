import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, CardContent, Typography, List } from '@mui/material';
import backgroundImage from '../images/onepiece.jpeg';

const CharacterList = () => {
    const [characters, setCharacters] = useState([]);

    useEffect(() => {
        axios
            .get('http://localhost:8080/api/characters')
            .then((response) => setCharacters(response.data))
            .catch((error) => console.error('Error fetching characters:', error));
    }, []);

    return (
        <div
            style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center', // Align items in the center horizontally
                justifyContent: 'center', // Align items in the center vertically
                padding: '20px',
                backgroundImage: `url(${backgroundImage})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                minHeight: '100vh',
            }}
        >
            <Typography variant="h2" gutterBottom style={{ color: '#fff' }}>
                One Piece API
            </Typography>
            <List style={{ width: '100%', maxWidth: '600px' }}>
                {characters.map((character) => (
                    <Card
                        key={character.id}
                        style={{ marginBottom: '10px', background: 'rgba(255, 255, 255, 0.8)', width: '100%' }}
                    >
                        <CardContent>
                            <Typography variant="h6">{character.name}</Typography>
                            <Typography variant="body1">Rank: {character.rank}</Typography>
                            <Typography variant="body1">Job: {character.job}</Typography>
                            <Typography variant="body1">
                                Bounty: {character.bounty || 'N/A'}
                            </Typography>
                            {character.devilFruit && (
                                <Typography variant="body1">
                                    Devil Fruit: {character.devilFruit.nameFruit} -{' '}
                                    {character.devilFruit.abilities}
                                </Typography>
                            )}
                            <Typography variant="body1">
                                Crew: {character.crew ? character.crew.nameCrew : 'N/A'}
                            </Typography>
                            {character.haki && (
                                <Typography variant="body1">
                                    Haki: {character.haki.nameHaki} -{' '}
                                    {character.haki.descriptionHaki}
                                </Typography>
                            )}
                            {character.fightTactics && (
                                <Typography variant="body1">
                                    Fight Tactics: {character.fightTactics.nameTactics} -{' '}
                                    {character.fightTactics.type}
                                </Typography>
                            )}
                        </CardContent>
                    </Card>
                ))}
            </List>
        </div>
    );
};

export default CharacterList;
