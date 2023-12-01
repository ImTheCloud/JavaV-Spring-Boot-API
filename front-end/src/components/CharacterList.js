import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, CardContent, Typography, List } from '@mui/material';

const CharacterList = () => {
  const [characters, setCharacters] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/characters')
      .then(response => setCharacters(response.data))
      .catch(error => console.error('Error fetching characters', error));
  }, []);

  return (
    <div style={{ padding: '20px' }}>
      <Typography variant="h4" gutterBottom>Character List</Typography>
      <List>
        {characters.map(character => (
          <Card key={character.id} style={{ marginBottom: '10px' }}>
            <CardContent>
              <Typography variant="h5">{character.name}</Typography>
              <Typography variant="body1">Rank: {character.rank}</Typography>
              <Typography variant="body1">Job: {character.job}</Typography>
              <Typography variant="body1">Bounty: {character.bounty}</Typography>
              <Typography variant="body1">Devil Fruit: {character.devilFruit.nameFruit} - {character.devilFruit.abilities}</Typography>
              <Typography variant="body1">Crew: {character.crew.nameCrew}</Typography>
              <Typography variant="body1">Haki: {character.haki.nameHaki} - {character.haki.descriptionHaki}</Typography>
              <Typography variant="body1">Fight Tactics: {character.fightTactics.nameTactics} - {character.fightTactics.type}</Typography>
            </CardContent>
          </Card>
        ))}
      </List>
    </div>
  );
};

export default CharacterList;
